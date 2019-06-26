package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.R
import `fun`.gladkikh.app.fastcountpallet.ui.base.BaseFragment
import com.uber.autodispose.AutoDispose

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
                        10 -> navController.navigate(R.id.aboutFragment)
                    }
                }
            }
    }

    override fun getLayout() = R.layout.listdoc_fragment
}