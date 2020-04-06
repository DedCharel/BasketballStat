package ru.nvg_soft.basketballstat.actyvities

import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Build

import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat

import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_add_person.*
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.models.DBManager
import ru.nvg_soft.basketballstat.presenters.AddPersonPresenter
import ru.nvg_soft.basketballstat.views.AddPersonView

class AddPersonActivity:MvpAppCompatActivity(),AddPersonView {

    @InjectPresenter
    lateinit var addPersonPresenter: AddPersonPresenter
    val dbTable="Person"
    var id=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        try{
            var bundle:Bundle= intent.extras!!
            id=bundle.getInt("ID",0)
            if(id!=0) {
                etName.setText(bundle.getString("name") )
                etDOB.setText(bundle.getString("dob") )
                etHeight.setText(bundle.getString("height") )
                etWeight.setText(bundle.getString("weight"))
             //  ivImagePerson.setImageBitmap(getImage(bundle.getByteArray("image")))

            }
        }catch (ex:Exception){}

        ivImagePerson.setOnClickListener(View.OnClickListener {
            checkPermission()
        })
//        ivRotateLeft.setOnClickListener(){
//            ivImagePerson.invalidate()
//            val bitmap = ivImagePerson.drawingCache
//            ivImagePerson.setImageBitmap(bitmap.rotate(90F))
//        }
//        ivRotateRight.setOnClickListener(){
//            ivImagePerson.setImageBitmap( RotateBitmap(ivImagePerson.drawingCache,-90f))
//        }
    }

    fun onClickAdd(view: View){
        var dbManager = DBManager(this)
        var values = ContentValues()
        values.put("Name", etName.text.toString())
        values.put("DOB", etDOB.text.toString())
        values.put("Weight", etWeight.text.toString())
        values.put("Height", etHeight.text.toString())

        if (id==0) {
            val ID = dbManager.Insert(values)
            if (ID > 0) {
                Toast.makeText(this, " person is added", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, " canot add person", Toast.LENGTH_LONG).show()
            }
        }else{
            var selectionArs= arrayOf(id.toString())
            val ID = dbManager.Update(values,"ID=?",selectionArs)
            if (ID > 0) {
                Toast.makeText(this, " person is added", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, " cannot add person ", Toast.LENGTH_LONG).show()
            }
        }

    }

    val READIMAGE:Int = 253
    fun checkPermission(){
        if(Build.VERSION.SDK_INT>=23){
            if (ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), READIMAGE)
                return
            }
        }
        loadImage()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            READIMAGE ->{
                if (grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    loadImage()
                }else{
                    Toast.makeText(this,"Cannot access your image",Toast.LENGTH_LONG).show()
                }
            } else ->super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }

    }
    val PICK_IMAGE_CODE = 123
    fun loadImage(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_CODE && data!=null){
            val selectedImage = data.data
            val filePathColum = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = contentResolver.query(selectedImage,filePathColum, null,null, null)
            cursor.moveToFirst()
            val columIndex = cursor.getColumnIndex(filePathColum[0])
            val picturePath = cursor.getString(columIndex)
            val fullpic = BitmapFactory.decodeFile(picturePath)

            val fullWidth = fullpic.width
            val fullHeight = fullpic.height
            val dev = fullHeight / 200
            val pic = Bitmap.createScaledBitmap(fullpic, fullWidth / dev,fullHeight / dev, false)

            val pic1 = pic.rotate(-90f)
            ivImagePerson.setImageBitmap(pic1)

        }
    }
    fun Bitmap.rotate(degrees: Float): Bitmap {
        val matrix = Matrix().apply { postRotate(degrees) }
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }
    fun getImage(image: ByteArray): Bitmap? {
        return BitmapFactory.decodeByteArray(image, 0, image.size)
    }
}

