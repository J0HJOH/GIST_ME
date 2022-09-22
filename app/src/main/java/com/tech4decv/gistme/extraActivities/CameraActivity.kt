package com.tech4decv.gistme.extraActivities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tech4decv.gistme.R

class CameraActivity : AppCompatActivity() {
    private lateinit var CameraPreview: PreviewView
    private lateinit var PhotoButton: FloatingActionButton
    private lateinit var imageCaptured: ImageCapture

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        CameraPreview= findViewById(R.id.CameraPreview)
        PhotoButton = findViewById(R.id.takePhotoButton)

        if(allPermissionGranted()){
//            start camera
            startCamera()
//            set listener to photoButton
            PhotoButton.setOnClickListener {
                Toast.makeText(this,"image captured...", Toast.LENGTH_LONG).show()
            }
        }else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                111
            )
        }
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==111 && allPermissionGranted()){
            startCamera()
        }else{
            finish()
        }
    }
    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener({
            //          bind to lifecycle
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build()
            preview.setSurfaceProvider(CameraPreview.surfaceProvider)

            imageCaptured = ImageCapture.Builder().build()

            //                select front/back camera
            val cameraSelected = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(
                    this,
                    cameraSelected,
                    preview,
                    imageCaptured
                )
            } catch (e: Exception) {
                Log.e("GISTME", "Camera Binding Failed $e")

                Toast.makeText(this, "Camera Binding unsuccessful", Toast.LENGTH_LONG)
                    .show()
            }
        }, ContextCompat.getMainExecutor(this))
    }

    private fun allPermissionGranted(): Boolean {
        return  ContextCompat.checkSelfPermission(this,
            Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED
    }

}