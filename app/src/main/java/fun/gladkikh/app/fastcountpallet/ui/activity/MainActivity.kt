package `fun`.gladkikh.app.fastcountpallet.ui.activity

import `fun`.gladkikh.app.fastcountpallet.R
import `fun`.gladkikh.app.fastcountpallet.ui.base.BaseActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.progress_overlay.*

class MainActivity : BaseActivity(),HostActivity {

    private lateinit var navController: NavController

    override fun showMessage(text: CharSequence) {
        Snackbar.make(root, text, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    override fun getHostNavController() = navController

    override fun isShowProgress() = (progressView.visibility == View.VISIBLE)

    override fun showProgress() {
        progressView.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressView.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }


    override fun getLayout() = R.layout.activity_main
}
