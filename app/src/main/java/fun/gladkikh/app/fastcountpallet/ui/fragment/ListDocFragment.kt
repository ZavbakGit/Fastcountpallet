package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.R
import `fun`.gladkikh.app.fastcountpallet.ui.base.BaseFragment
import android.os.Bundle
import androidx.navigation.NavOptions
import com.uber.autodispose.AutoDispose
import java.util.*

class ListDocFragment : BaseFragment() {


    override fun initSubscription() {
        super.initSubscription()
        val options = NavOptions.Builder().
            setEnterAnim(R.anim.nav_custom_enter_anim).
            build()

        getKeyListenerFlowable()
            .`as`(AutoDispose.autoDisposable(scopeProvider))
            .subscribe {
                if (!hostActivity.isShowProgress()) {
                    when (it) {
                        8 -> navController.navigate(R.id.helpFragment,null,options)
                        9 -> navController.navigate(R.id.settingsFragment,null,options)
                        10 -> navController.navigate(R.id.aboutFragment,
                            Bundle().apply { putString("description","О программе ${Date()}") },
                            options)
                    }
                }
            }
    }

    override fun getLayout() = R.layout.listdoc_fragment
}