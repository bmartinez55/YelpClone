package c.bmartinez.yelpclone.presentation.location_details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class LocationDetailFragment: Fragment() {

    private val TAG = LocationDetailFragment::class.java.toString()

    private lateinit var locationID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getString("locationID")?.let { id ->
            this.locationID = id
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                //val businessDetails = viewModel.locationBusinessDetails.value
                val navController = findNavController()

//                Column(modifier = Modifier.fillMaxSize()) {
//                    LocationDetailsView(location = businessDetails, navController)
//                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //populateView()
    }

//    private fun populateView() {
//        retrofitService = RetrofitService.getInstance(requireContext())
//        yelpRepository = YelpRepository(retrofitService)
//        viewModel = ViewModelProvider(this, MyViewModelFactory(yelpRepository)).get(MainViewModel::class.java)
//
////        Log.d(TAG, "Before calling getBusinessDetails()")
////        CoroutineScope(Dispatchers.IO).launch { viewModel.getBusinessDetails(locationID) }
//    }
}