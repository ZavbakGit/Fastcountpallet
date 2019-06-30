package `fun`.gladkikh.app.fastcountpallet.modelview

import `fun`.gladkikh.app.fastcountpallet.ui.utility.SingleLiveEvent
import androidx.lifecycle.ViewModel

class DialogViewModel:ViewModel(){
    val dialogMess = SingleLiveEvent<String>()
}