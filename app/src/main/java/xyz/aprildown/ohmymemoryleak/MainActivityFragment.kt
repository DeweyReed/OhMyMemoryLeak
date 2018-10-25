package xyz.aprildown.ohmymemoryleak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import xyz.aprildown.ohmymemoryleak.databinding.FragmentMainBinding

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        // Both of these cause memory leaks.
        binding.setLifecycleOwner(this)
//        binding.setLifecycleOwner(viewLifecycleOwner)
        return binding.root
    }
}
