package `fun`.gladkikh.app.fastcountpallet.ui.activity

import androidx.navigation.NavController
import io.reactivex.Flowable

interface HostActivity{
    fun showMessage(text: CharSequence)
    fun isShowProgress():Boolean
    fun showProgress()
    fun hideProgress()
    fun getKeyListenerFlowable():Flowable<Int>
    fun getHostNavController(): NavController
}