package com.example.telegram.ui.objects

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegram.R
import com.example.telegram.databinding.ActivityMainBinding
import com.example.telegram.ui.fragments.SettingsFragment
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.descriptionText
import com.mikepenz.materialdrawer.model.interfaces.iconRes
import com.mikepenz.materialdrawer.model.interfaces.nameRes
import com.mikepenz.materialdrawer.model.interfaces.nameText
import com.mikepenz.materialdrawer.widget.AccountHeaderView
import com.mikepenz.materialdrawer.widget.MaterialDrawerSliderView

class AppDrawer(private val mainActivity:AppCompatActivity, val toolbar: Toolbar, private val binding: ActivityMainBinding) {

    private lateinit var mDrawer: MaterialDrawerSliderView
    private lateinit var mHeader: AccountHeaderView

    fun create(){
        createHeader()
        createDrawer()
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

        mDrawer = binding.drawer.apply {
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
                when(position){
                    7 -> mainActivity.supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.dataContainer, SettingsFragment()).commit()
                }
                false
            }
        }
    }

    private fun createHeader() {
        mHeader = AccountHeaderView(mainActivity).apply {
            setBackgroundResource(R.drawable.header)
            attachToSliderView(binding.drawer)
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
}