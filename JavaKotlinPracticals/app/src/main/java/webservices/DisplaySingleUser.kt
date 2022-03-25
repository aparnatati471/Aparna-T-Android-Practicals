package webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityDisplaySingleUserBinding
import com.example.javakotlinpracticals.databinding.CustomAlertDialogBinding
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class DisplaySingleUser : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDisplaySingleUserBinding
    private lateinit var binding2: CustomAlertDialogBinding
    private val pos: Int
        get() {
            return intent.getIntExtra("userId", 2)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplaySingleUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickOne = this
        Thread {
            try {
                loadSingleUser()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }.start()
    }

    // Patch Data
    private fun patchData() {
        ApiClient().retrofitBuilder.patchUserData(
            pos,
            RequestForAddUser("morpheus", "zion resident")
        ).enqueue(object : retrofit2.Callback<ResposeForUpdate> {
            override fun onResponse(
                call: Call<ResposeForUpdate>,
                response: Response<ResposeForUpdate>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        Toast.makeText(
                            applicationContext,
                            "Data Updated Successfully!\n${response.body()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Data Not Updated Successfully!",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }

            override fun onFailure(call: Call<ResposeForUpdate>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed to Patch user data!", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    // Delete Data
    private fun deleteData() {
        ApiClient().retrofitBuilder.deleteUserData(pos).enqueue(object : retrofit2.Callback<Unit> {
            override fun onResponse(
                call: Call<Unit>,
                response: Response<Unit>
            ) {
                if (response.code() == 204) {
                    Toast.makeText(
                        applicationContext,
                        "Data Deleted Successfully!\n${response.code()}",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Data Not Deleted Successfully!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed to Delete user data!", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    // Update Data
    private fun updateData() {
        ApiClient().retrofitBuilder.updateUserData(
            pos,
            RequestForAddUser("morpheus", "zion resident")
        ).enqueue(object : retrofit2.Callback<ResposeForUpdate> {
            override fun onResponse(
                call: Call<ResposeForUpdate>,
                response: Response<ResposeForUpdate>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        Toast.makeText(
                            applicationContext,
                            "Data Updated Successfully!\n${response.body()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Data Not Updated Successfully!\n${response.body()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResposeForUpdate>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed to Update user data", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    // Dialog for creating user
    private fun showDialog() {
        binding2 = CustomAlertDialogBinding.inflate(layoutInflater)
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.custom_alert_dialog, null)
        dialogBuilder.setView(view)
        val alertDialog = dialogBuilder.create()
        binding2.create.setOnClickListener {
            addData()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }

    // Add Data
    private fun addData() {
        ApiClient().retrofitBuilder.addUser(RequestForAddUser("morpheus", "leader"))
            .enqueue(object : retrofit2.Callback<ResponseForAddUser> {
                override fun onResponse(
                    call: Call<ResponseForAddUser>,
                    response: Response<ResponseForAddUser>
                ) {
                    if (response.code() == 201) {
                        response.body()?.let {
                            Toast.makeText(
                                applicationContext,
                                "Data Added Successfully!\n${response.body()}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Data Not Added Successfully!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponseForAddUser>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed to Add User Data", Toast.LENGTH_LONG)
                        .show()
                }
            })
    }

    // get single user on item click in recyclerview
    private fun loadSingleUser() {
        pos.let {
            ApiClient().retrofitBuilder.getSingleUser(it)
                .enqueue(object : retrofit2.Callback<SingleUserDataclass> {
                    override fun onResponse(
                        call: Call<SingleUserDataclass>,
                        response: Response<SingleUserDataclass>
                    ) {
                        if (response.code() == 200) {
                            response.body()?.let {
                                val responseData = it
                                Glide.with(this@DisplaySingleUser).load(responseData.data.avatar)
                                    .circleCrop().into(binding.personImage)
                                binding.personEmail.text = responseData.data.email
                                binding.personFirstName.text = responseData.data.firstName
                                binding.personLastName.text = responseData.data.lastName
                                Toast.makeText(
                                    applicationContext,
                                    responseData.data.firstName,
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<SingleUserDataclass>, t: Throwable) {
                        runOnUiThread {
                            Toast.makeText(
                                this@DisplaySingleUser,
                                "Data Not Loaded",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                })
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.fab.id -> showDialog()
            binding.update.id -> updateData()
            binding.delete.id -> deleteData()
            binding.patch.id -> patchData()
        }
    }

}
