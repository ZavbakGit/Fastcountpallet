package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.modelview.DialogViewModel
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import java.util.*

class MyDialog:DialogFragment(){
    lateinit var  viewModelDialog: DialogViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        viewModelDialog = ViewModelProviders.of(activity!!)
            .get(DialogViewModel::class.java)

        return AlertDialog.Builder(requireActivity())
            .setTitle("Dialog")
            .setMessage(arguments?.getString("mess"))
            .setPositiveButton("OK") { _, which ->
                sendResult(which)
            }
            .create()
    }

    private fun sendResult(which: Int) {
        targetFragment?.onActivityResult(targetRequestCode, which, null)
        viewModelDialog.dialogMess.value = "Hi ${Date()}"
    }

}