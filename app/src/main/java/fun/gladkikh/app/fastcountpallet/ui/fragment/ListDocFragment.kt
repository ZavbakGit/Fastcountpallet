package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.R
import `fun`.gladkikh.app.fastcountpallet.ui.base.BaseFragment
import android.os.Bundle
import com.uber.autodispose.AutoDispose
import java.util.*

class ListDocFragment : BaseFragment() {


    override fun initSubscription() {
        super.initSubscription()
        getKeyListenerFlowable()
            .`as`(AutoDispose.autoDisposable(scopeProvider))
            .subscribe {
                if (!hostActivity.isShowProgress()) {
                    when (it) {
                        8 -> navController.navigate(R.id.helpFragment)
                        9 -> navController.navigate(R.id.settingsFragment)
                        10 -> navController.navigate(R.id.aboutFragment,
                            Bundle().apply { putString("description","О программе ${Date().toString()}") })
                    }
                }
            }
    }

    override fun getLayout() = R.layout.listdoc_fragment
}