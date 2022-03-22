package com.example.navidrawertest;

import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/*
*Navigation은 4개의 모듈로 나뉘는데
1. navigation-common : 내부적으로 동작하는 부분
2. navigation-runtime : NavController
3. navigation-fragment : NavHostFragment, Destinations(Fragment)
4. navigation-UI : bottom-navigation, appBar 등의 UI 동작을 지원함
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // appBarConfiguration 객체를 사용하여 앱 표시 영역의 왼쪽 상단 모서리에 있는 탐색 버튼의 동작을 관리함
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow).setDrawerLayout(drawer).build();

        // NavController 객체를 사용하여 이동할 수 있으며, NavHost 내에서 앱 탐색을 관리함
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // NavigationUi로 UI를 동작 시킴
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() { // 상단 탐색을 처리함
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}