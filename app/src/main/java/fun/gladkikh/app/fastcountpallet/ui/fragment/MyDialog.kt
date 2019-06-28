package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.R
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialog:DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        return AlertDialog.Builder(requireActivity())
            .setTitle("Dialog")
            .setMessage("Hi")
            .setPositiveButton("OK") { _, which ->
                sendResult(which)
            }
            .create()
    }

    private fun sendResult(which: Int) {
        targetFragment?.onActivityResult(targetRequestCode, which, null)
    }

}