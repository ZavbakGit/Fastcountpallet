package `fun`.gladkikh.app.fastcountpallet.ui.base

import `fun`.gladkikh.app.fastcountpallet.ui.activity.HostActivity
import `fun`.gladkikh.app.fastcountpallet.ui.activity.MainActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import io.reactivex.Flowable

abstract class BaseFragment: Fragment() {

    lateinit var navController: NavController


    lateinit var hostActivity: HostActivity

    protected val scopeProvider: AndroidLifecycleScopeProvider by lazy { AndroidLifecycleScopeProvider.from(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hostActivity = activity as MainActivity
        navController = (activity as MainActivity).getHostNavController()
    }

    override fun onResume() {
        super.onResume()
        initSubscription()
    }

    fun getKeyListenerFlowable(): Flowable<Int> = hostActivity.getKeyListenerFlowable()

    abstract fun getLayout(): Int

    protected open fun initSubscription(){}

}