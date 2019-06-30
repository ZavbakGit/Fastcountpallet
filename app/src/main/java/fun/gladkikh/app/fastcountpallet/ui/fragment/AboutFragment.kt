package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.R
import `fun`.gladkikh.app.fastcountpallet.modelview.DialogViewModel
import `fun`.gladkikh.app.fastcountpallet.ui.base.BaseFragment
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.uber.autodispose.AutoDispose
import kotlinx.android.synthetic.main.about_fragment.*
import java.util.*

class AboutFragment : BaseFragment() {


    lateinit var viewModelDialog: DialogViewModel


    override fun initSubscription() {
        super.initSubscription()
        viewModelDialog = ViewModelProviders.of(activity!!)
            .get(DialogViewModel::class.java)

        viewModelDialog.dialogMess.observe(viewLifecycleOwner, Observer { mess ->
            hostActivity.showMessage(mess)
        })

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
            navController.navigate(R.id.myDialog,
                Bundle().apply { putString("mess", "Диалог ${Date()}") })
        }

        tvMessage.text = arguments?.getString("description")

    }


    override fun getLayout() = R.layout.about_fragment
}