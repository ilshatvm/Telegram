package com.example.telegram

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.telegram.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.descriptionText
import com.mikepenz.materialdrawer.model.interfaces.iconRes
import com.mikepenz.materialdrawer.model.interfaces.nameRes
import com.mikepenz.materialdrawer.model.interfaces.nameText
import com.mikepenz.materialdrawer.widget.AccountHeaderView
import com.mikepenz.materialdrawer.widget.MaterialDrawerSliderView

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: MaterialDrawerSliderView
    private lateinit var mHeader: AccountHeaderView
    private lateinit var mToolbar: Toolbar
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {

        createHeader()
        createDrawer()
        initActionBar()
    }

    private fun initActionBar() {
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            mToolbar,
            com.mikepenz.materialdrawer.R.string.material_drawer_open,
            com.mikepenz.materialdrawer.R.string.material_drawer_close
        )
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun createDrawer() {
        val itemCreateGroup = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_create_group
            iconRes = R.drawable.ic_menu_create_groups
            identifier = 1
        }
        val itemCreateSecretChat = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_create_secret_chat
            iconRes = R.drawable.ic_menu_secret_chat
            identifier = 2
        }
        val itemCreateChannel = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_create_channel
            iconRes = R.drawable.ic_menu_create_channel
            identifier = 3
        }
        val itemContacts = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_contacts
            iconRes = R.drawable.ic_menu_contacts
            identifier = 4
        }
        val itemCalls = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_calls
            iconRes = R.drawable.ic_menu_phone
            identifier = 5
        }
        val itemFavorites = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_favorites
            iconRes = R.drawable.ic_menu_favorites
            identifier = 6
        }
        val itemSettings = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_settings
            iconRes = R.drawable.ic_menu_settings
            identifier = 7
        }
        val itemInvite = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_invite
            iconRes = R.drawable.ic_menu_invite
            identifier = 8
        }
        val itemHelp = PrimaryDrawerItem().apply {
            nameRes = R.string.drawer_item_action_help
            iconRes = R.drawable.ic_menu_help
            identifier = 9
        }

        mDrawer = mBinding.drawer.apply {
            itemAdapter.add(
                itemCreateGroup,
                itemCreateSecretChat,
                itemCreateChannel,
                itemContacts,
                itemCalls,
                itemFavorites,
                itemSettings,
                DividerDrawerItem(),
                itemInvite,
                itemHelp,
            )
            onDrawerItemClickListener = { _, _, position ->
                Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
                false
            }
        }
    }

    private fun createHeader() {
        mHeader = AccountHeaderView(this).apply {
            setBackgroundResource(R.drawable.header)
            attachToSliderView(mBinding.drawer)
            addProfiles(
                ProfileDrawerItem().apply {
                    nameText = "Yura Petrov"
                    descriptionText = "+79111111111"
                    iconRes = R.drawable.ic_launcher_background
                    identifier = 102
                }
            )
        }
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mDrawerLayout = mBinding.root
    }
}