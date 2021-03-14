package com.example.sqlite

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ContentProvider : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    lateinit var text: TextView
    private var type: String? = null
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        var btn_file = findViewById<Button>(R.id.file)
        text = findViewById(R.id.hello)
        imageView=findViewById(R.id.CP_image)
        btn_file.setOnClickListener() {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.setType("image/*")

            startActivityForResult(intent, 1)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            var uri = data.getData()

            Log.i("uriPath", "uriPath is $uri *****  ")
            Toast.makeText(this, "path is $uri and selected path ish", Toast.LENGTH_SHORT).show()
            //startIntent(uri!!)
           // startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri?.toString())))

            try {
                var bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri)
                //saveBitmapIntoSDcardImage(this,bitmap)
                var selectedPath = SaveInPrivateSpace(bitmap)
                imageView.setImageBitmap(bitmap)

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    private fun SaveInPrivateSpace(bitmap:Bitmap) {

        var cw = ContextWrapper(applicationContext)
        var dir = cw.getDir("imageDir", Context.MODE_PRIVATE)
        var file = File(dir, "UniqueFileName" + ".jpg")
        if(!file.exists()){
            Log.d("path", file.toString())
            var fos:FileOutputStream? = null
            try {
                fos = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,fos)
                fos.flush()
                fos.close()
            }
            catch (e:IOException)
            {e.printStackTrace()}
        }

//        if (uri == null) {
//
//            return null
//        }
//        // try to retrieve the image from the media store first
//        // this will only work for images selected from gallery
//        // try to retrieve the image from the media store first
//        // this will only work for images selected from gallery
//        val projection = arrayOf(MediaStore.Images.Media.DATA)
//        val cursor = getContentResolver().query(uri, projection, null, null, null)
//        if (cursor != null) {
//            val column_index = cursor
//                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
//            cursor.moveToFirst()
//            val path = cursor.getString(column_index)
//            cursor.close()
//            return path
//        }
//        // this is our fallback here
//        // this is our fallback here
//        return uri.path!!

    }

//    private fun saveBitmapIntoSDcardImage(uri: Uri, bitmap: Bitmap?) {
//
//
//        val outStream: FileOutputStream
//                val mediaStorageDir: String =
//                        "" + requireContext(uri).getExternalFilesDir(null) + "/ABC"
//                val mFolder = File(mediaStorageDir)
//                if (!mFolder.exists()) {
//                    mFolder.mkdir()
//                }
//                var outFile = File(mFolder, "$imageName.png")
//                outStream = FileOutputStream(outFile)
//                bitmap?.compress(Bitmap.CompressFormat.PNG, 100, outStream)
//                outStream.flush()
//                outStream.close()
//    }

//    private fun startIntent(uri: Uri) {
//       var intent = Intent()
//        intent.setAction(Intent.ACTION_VIEW)
//
//    }
}

//        when (requestCode) {
//            1 -> if (resultCode == Activity.RESULT_OK) {
//                var uri: Uri = data?.getData()!!
//                var filepath = data.getData()!!.getPath()
//                var fileName = data.getData()!!.getLastPathSegment()
//                var lastPos = filepath!!.length - fileName!!.length
//                var folder = filepath.substring(0,lastPos)
//
//                Log.i("filenames", "filepath is $filepath *** filename is $fileName *** folder is $folder")
//
//                if(uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)){
//                    var cr = this.getApplicationContext().getContentResolver();
//                    type = cr.getType(uri)
//
//                }
//                else{
//                    var fleExt = MimeTypeMap.getFileExtensionFromUrl(uri.toString())
//                    type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(uri.toString())
//                }
//
//                var path = uri.path
//
//                text.setText(path)
//                Log.i("path-uri", "path  is $path **** Type is $type *** ")
              //  var image = findViewById<ImageView>(R.id.CP_image)


             //   image.setImageURI(Uri.fromFile(File(type)))

//                val outStream: FileOutputStream
//                val mediaStorageDir: String =
//                        "" + requireContext(uri).getExternalFilesDir(null) + "/ABC"
//                val mFolder = File(mediaStorageDir)
//                if (!mFolder.exists()) {
//                    mFolder.mkdir()
//                }
//                var outFile = File(mFolder, "$imageName.png")
//                outStream = FileOutputStream(outFile)
//                bitmap?.compress(Bitmap.CompressFormat.PNG, 100, outStream)
//                outStream.flush()
//                outStream.close()


//            }
//        }
//    }
//