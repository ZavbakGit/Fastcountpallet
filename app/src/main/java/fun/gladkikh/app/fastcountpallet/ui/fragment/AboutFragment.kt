package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.R
import `fun`.gladkikh.app.fastcountpallet.ui.base.BaseFragment
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uber.autodispose.AutoDispose
import kotlinx.android.synthetic.main.about_fragment.*

class AboutFragment : BaseFragment() {

    companion object {
        private const val DIALOG_REQUEST_CODE = 1
    }


    override fun initSubscription() {
        super.initSubscription()
        getKeyListenerFlowable()
            .`as`(AutoDispose.autoDisposable(scopeProvider))
            .subscribe {
                if (!hostActivity.isShowProgress()) {
                    when (it) {
                        10 -> navController.navigateUp()
                    }
                }
            }

        tvMessage.setOnClickListener {
            navController.navigate(R.id.myDialog)
        }

        tvMessage.text = arguments?.getString("description")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (DIALOG_REQUEST_CODE == requestCode && DialogInterface.BUTTON_POSITIVE == resultCode) {
            hostActivity.showMessage("Click button positive")
        }
    }

    override fun getLayout() = R.layout.about_fragment
}