package `fun`.gladkikh.app.fastcountpallet.ui.fragment

import `fun`.gladkikh.app.fastcountpallet.R
import `fun`.gladkikh.app.fastcountpallet.ui.activity.MainActivity
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider


class SettingsFragment : PreferenceFragmentCompat() {
    private val scopeProvider: AndroidLifecycleScopeProvider by lazy { AndroidLifecycleScopeProvider.from(this) }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).getKeyListenerFlowable()
            .`as`(AutoDispose.autoDisposable(scopeProvider))
            .subscribe {
                if (!(activity as MainActivity).isShowProgress()) {
                    when (it) {
                        9 -> (activity as MainActivity).getHostNavController().navigateUp()
                    }
                }
            }
    }
}