# android-MVP
android 使用MVP开发模式
Android MVP 例子:
=====================
    MVP开发模式越来越多人在使用。之前我们的做法太多数是以MVC进行开发。项目后期越来越大时，代码越来越难维护。别人都说，最容易删除代码的代码才是好代码，同时也是最好的开发模式
本Demo的业务需求:
------------------------------------
   启动页，引导页，登录，主页。启动页显示5000ms，判断是否是第一次启动，以当前版本号和本地保存的版本号作比较。同时还要判断是否登录过。以保存用户状态做比较。业务如下：用户未登录（以用户登录为基准，引导页是否加载过），直接加载引导页。如果已经登录，比较本地保存的版本号小于当前版本号当要加载引导页，如果不小于直接进入到主页程序。

###启动页Activity

public class StartActivity extends BaseActivity implements IStartView {

    private StartPresenter mStartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mStartPresenter = new StartPresenter(this);
        mStartPresenter.onCreate(this);

    }

    @Override
    public void startMain() {
        UIHelper.startMain(this);
        finish();

    }

    @Override
    public void startGuide() {

        UIHelper.startActivity(this, GuideActivity.class, null);
        finish();

    }
}


###启动页控制器Presenter


public class StartPresenter {

    private IStartView mIStartView;

    private LocalVersion mLocalVersion;

    public StartPresenter(IStartView iStartView) {
        mIStartView = iStartView;

    }

    public void onCreate(final Context context) {
        Log.e("fs","onCreatekkkkkkkk......................................................................................................");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mLocalVersion = new LocalVersion();

                int localVersion = mLocalVersion.getLocalVersion(context);//获取model保存的版本号

                int systemVersion = SystemVersionInfo.getVersionCode(context);//获取当前的版本号


                UserEntity userEntity = LocalUserInfo.getUserInfo(context);//获取用户登录状态

                if (TextUtils.isEmpty(userEntity.token)){

                    Log.e("fd","fgfgfgfgf---------------------------------------------------------------------------------------------------------------");
                    mIStartView.startGuide();
                    return;
                }

                if (localVersion < systemVersion) {


                    Log.e("fd","fffff--------------------------------------------------------------------------------------------------------------");
                    mIStartView.startGuide();
                    return;

                }


                Log.e("fd","gggggggg---------------------------------------------------------------------------------------------------------------");
                mIStartView.startMain();
            }
        },5000);

    }
}

###Model层
用户登录状态：

public class LocalUserInfo {


    public static UserEntity getUserInfo(Context context) {

        UserEntity userEntity = new UserEntity();

        userEntity.token =SharedPrefsUtil.getValue(context,"TOKEN","token",null);




        return userEntity;


    }


    public static void saveUserInfo(Context context,UserEntity userEntity) {

        SharedPrefsUtil.putValue(context,"TOKEN","token",userEntity.token);



        //保存数据
    }


}

保存的版本号：

public class LocalVersion {


    private String mFileName = "VERSION";
    private String mVersionKey = "version";

    public int getLocalVersion(Context context) {

        //对于调用者来说。只关心结果。

        int version = SharedPrefsUtil.getValue(context, mFileName, mVersionKey, 0);

        return version;

    }

    public void saveLocalVersion(Context context, int version) {

        //对于调用者来说。不关心是如果保存的,也不关心我保存的ＫＥＹ 和 文件是什么。只要保存
        SharedPrefsUtil.putValue(context, mFileName, mVersionKey, version);

    }

}
### MVP 中 P与Ｖ的交互，以接口的形式
public interface IStartView {

    void startMain();

    void startGuide();
}

### MVP 中 P与Ｍ的交互
为了解耦最好以接口的形式交互。model的概念，如网络请求，本地数据，等

#####鸣谢
在我学习MVP时。得到很多人的帮忙于解答。
QuickAndroid(432563131)技术群里的：
作者：壳
成员：朽木，替补，老八，roy,轮回等
