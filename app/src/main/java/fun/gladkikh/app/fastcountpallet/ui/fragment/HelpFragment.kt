package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.R
import `fun`.gladkikh.app.fastcountpallet.ui.base.BaseFragment
import com.uber.autodispose.AutoDispose

class HelpFragment :BaseFragment(){

    override fun initSubscription() {
        super.initSubscription()
        getKeyListenerFlowable()
            .`as`(AutoDispose.autoDisposable(scopeProvider))
            .subscribe {
                if (!hostActivity.isShowProgress()) {
                    when (it) {
                        8 -> navController.navigateUp()
                    }
                }
            }
    }

    override fun getLayout() = R.layout.help_fragment
}

