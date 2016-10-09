package vampire.com.androidprojectb.tool.dbtool;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import vampire.com.androidprojectb.base.MyApp;

/**
 * Created by Vampire on 16/9/20.
 */
public class DBTool {
    private static DBTool ourInstance;
    ExecutorService threadPool = Executors.newFixedThreadPool(getNumCores() + 1);
    private DBFavoriteDao dbFavoriteDao;
    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper helper;
    private final static String DB_NAME = "projectB.db";


    private DBTool() {
        helper = new DaoMaster.DevOpenHelper(MyApp.getContext(), DB_NAME);
    }

    public static DBTool getInstance() {
        if (ourInstance == null) {
            synchronized (DBTool.class) {
                if (ourInstance == null) {
                    ourInstance = new DBTool();
                }
            }
        }
        return ourInstance;
    }

    // 获取可读数据库
    private SQLiteDatabase getReadableDatabase() {
        if (helper == null) {
            helper = new DaoMaster.DevOpenHelper(MyApp.getContext(), DB_NAME);
        }
        SQLiteDatabase database = helper.getReadableDatabase();
        return database;
    }

    // 获取可写数据库
    private SQLiteDatabase getWritableDatabase() {
        if (helper == null) {
            helper = new DaoMaster.DevOpenHelper(MyApp.getContext(), DB_NAME);
        }
        SQLiteDatabase database = helper.getWritableDatabase();
        return database;

    }

    // 增一条
    public void insertFavorite(final DBFavorite dbFavorite) {
        threadPool.execute(new Runnable() {
            private List<DBFavorite> dbFavorites;

            @Override
            public void run() {
                DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
                daoSession = daoMaster.newSession();
                dbFavoriteDao = daoSession.getDBFavoriteDao();
                if (dbFavorite.getUrl() != null) {
                    dbFavorites = dbFavoriteDao.queryBuilder()
                            .where(DBFavoriteDao.Properties.Url.eq(dbFavorite.getUrl()))
                            .build().list();
                } else {
                    dbFavorites = dbFavoriteDao.queryBuilder()
                            .where(DBFavoriteDao.Properties.Title.eq(dbFavorite.getTitle()))
                            .build().list();
                }

                if (dbFavorites.size() == 0) {
                    Log.d("DBTool", "存");
                    dbFavoriteDao.insert(dbFavorite);
                } else {
                    Log.d("DBTool", "数据已存在");
                }
            }
        });

    }

    // 增集合
    public void insertFavorite(final List<DBFavorite> dbFavorites) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                if (dbFavorites == null || dbFavorites.isEmpty()) {
                    return;
                }
                DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
                DaoSession daoSession = daoMaster.newSession();
                DBFavoriteDao dbFavoriteDao = daoSession.getDBFavoriteDao();
                //下面的

                for (DBFavorite dbFavorite : dbFavorites) {
                    List<DBFavorite> dbFavorites = dbFavoriteDao.queryBuilder()
                            .where(DBFavoriteDao.Properties.Url.eq(dbFavorite.getUrl())).build().list();
                    if (dbFavorites.size() == 0) {

                        Log.d("DBTool", "存");
                        dbFavoriteDao.insert(dbFavorite);
                    } else {
                        Log.d("DBTool", "数据已存在");
                    }
                }
            }
        });
    }

    // 删一条
    public void delFavorite(final String url) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
                daoSession = daoMaster.newSession();
                dbFavoriteDao = daoSession.getDBFavoriteDao();
                DBFavorite dbFavorite = dbFavoriteDao.queryBuilder()
                        .where(DBFavoriteDao.Properties.Url.eq(url))
                        .build().unique();
                if (dbFavorite != null) {
                    dbFavoriteDao.deleteByKey(dbFavorite.getId());
                }
            }
        });
    }

    // 全删
    public void delFavorite() {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
                DaoSession daoSession = daoMaster.newSession();
                DBFavoriteDao dbFavoriteDao = daoSession.getDBFavoriteDao();
                dbFavoriteDao.deleteAll();
            }
        });
    }

    // 更新
    public void updateFavorite(final DBFavorite dbFavorite) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
                DaoSession daoSession = daoMaster.newSession();
                DBFavoriteDao dbFavoriteDao = daoSession.getDBFavoriteDao();
                dbFavoriteDao.update(dbFavorite);
            }
        });

    }

    // 查询Favorite数据库
    public void getFavorite(final String type, Action1<List<DBFavorite>> action1) {
        Observable.create(new Observable.OnSubscribe<List<DBFavorite>>() {

            private List<DBFavorite> dbFavorites;

            @Override
            public void call(Subscriber<? super List<DBFavorite>> subscriber) {
                if (type == null) {
                    Log.d("DBTool", "null");
                    dbFavorites = queryFavorite();
                } else {
                    Log.d("DBTool", "!null");
                    dbFavorites = queryFavorite(type);
                }
                subscriber.onNext(dbFavorites);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(action1);

    }

    // 根据title查数据库
    public void getFavoriteByTitle(final String type, final String title, Action1<List<DBFavorite>> action1) {
        Observable.create(new Observable.OnSubscribe<List<DBFavorite>>() {
            @Override
            public void call(Subscriber<? super List<DBFavorite>> subscriber) {
                List<DBFavorite> dbFavorites = queryFavorite(type, title);
                subscriber.onNext(dbFavorites);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(action1);
    }

    // 查询
    private List<DBFavorite> queryFavorite() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DBFavoriteDao dbFavoriteDao = daoSession.getDBFavoriteDao();
        QueryBuilder<DBFavorite> queryBuilder = dbFavoriteDao.queryBuilder();
        List<DBFavorite> dbFavorites = queryBuilder.list();
        Log.d("DBTool", Thread.currentThread().getName());
        return dbFavorites;

    }

    // 查询通过type
    private List<DBFavorite> queryFavorite(String type) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DBFavoriteDao dbFavoriteDao = daoSession.getDBFavoriteDao();
        List<DBFavorite> dbFavorites = dbFavoriteDao.queryBuilder()
                .where(DBFavoriteDao.Properties.Type.eq(type))
                .orderAsc(DBFavoriteDao.Properties.Type).build().list();
        return dbFavorites;
    }

    // 查文字内容
    private List<DBFavorite> queryFavorite(String type, String title) {
        List<DBFavorite> dbFavorites = queryFavorite(type);
        List<DBFavorite> result = new ArrayList<>();
        for (DBFavorite dbFavorite : dbFavorites) {
            if (dbFavorite.getTitle().equals(title)) {
                result.add(dbFavorite);
            }
        }
        return result;

    }


    // 获取CPU 核数
    private int getNumCores() {
        //Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                //Check if filename is "cpu", followed by a single digit number
                if (Pattern.matches("cpu[0-9]", pathname.getName())) {
                    return true;
                }
                return false;
            }
        }

        try {
            //Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            //Filter to only list the devices we care about
            File[] files = dir.listFiles(new CpuFilter());
            Log.d("dbTool", "CPU Count: " + files.length);
            //Return the number of cores (virtual CPU devices)
            return files.length;
        } catch (Exception e) {
            //Print exception
            Log.d("dbTool", "CPU Count: Failed.");
            e.printStackTrace();
            //Default to return 1 core
            return 1;
        }
    }


}
