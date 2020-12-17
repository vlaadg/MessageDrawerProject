package com.gvs.messengerapp.ui.objects;

import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gvs.messengerapp.MainActivity;
import com.gvs.messengerapp.R;
import com.gvs.messengerapp.ui.fragments.ContactFragment;
import com.gvs.messengerapp.ui.fragments.QuitFragment;
import com.gvs.messengerapp.ui.fragments.SettingsFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class AppDrawer {
    AppCompatActivity mainActivity;
    Toolbar toolbar;
    private Drawer mDrawer;
    private AccountHeader mHeader;

    public AppDrawer(AppCompatActivity mainActivity, Toolbar mToolbar) {
    }

    public void create(){
        createDrawer();
        createHeader();
    }


    private void createDrawer() {
        mDrawer = new DrawerBuilder()
                .withActivity(mainActivity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withSelectedItem(-1)
                .withAccountHeader(mHeader)
                .addDrawerItems(
                        new PrimaryDrawerItem().
                                withIdentifier(100)
                                .withIconTintingEnabled(true)
                                .withName("Создать групповой чат")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_chat),
                        new PrimaryDrawerItem().
                                withIdentifier(101)
                                .withIconTintingEnabled(true)
                                .withName("Создать личный чат")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_chat),
                        new PrimaryDrawerItem().
                                withIdentifier(102)
                                .withIconTintingEnabled(true)
                                .withName("Контакты")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_contacts),
                        new PrimaryDrawerItem().
                                withIdentifier(103)
                                .withIconTintingEnabled(true)
                                .withName("Настройки")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_settings),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().
                                withIdentifier(104)
                                .withIconTintingEnabled(true)
                                .withName("Выход")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_exit)
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position){
                            case 0:
//                                mainActivity.getSupportFragmentManager().beginTransaction()
//                                        .addToBackStack(null)
//                                        .replace(R.id.dataContainer, new SettingsFragment()).commit();
                            case 1:
//                                mainActivity.getSupportFragmentManager().beginTransaction()
//                                        .addToBackStack(null)
//                                        .replace(R.id.dataContainer, new ChatsFragment()).commit();
                            case 2:
                                mainActivity.getSupportFragmentManager().beginTransaction()
                                        .addToBackStack(null)
                                        .replace(R.id.dataContainer, new ContactFragment()).commit();
                            case 3:
                                mainActivity.getSupportFragmentManager().beginTransaction()
                                        .addToBackStack(null)
                                        .replace(R.id.dataContainer, new SettingsFragment()).commit();
                            case 4:
                                mainActivity.getSupportFragmentManager().beginTransaction()
                                        .addToBackStack(null)
                                        .replace(R.id.dataContainer, new QuitFragment());
                        }
                        Toast.makeText(mainActivity.getApplicationContext(), position, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }).build();
    }

    private void createHeader() {
        mHeader = new AccountHeaderBuilder()
                .withActivity(mainActivity)
                .withHeaderBackground(R.drawable.ic_launcher_background)
                .addProfiles(
                        new ProfileDrawerItem().withName("Vlad")
                                .withEmail("vlad@mail.ru")
                ).build();
    }
}
