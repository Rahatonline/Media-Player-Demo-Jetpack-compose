package com.rahatshah.mediaplayerdemo.data



import android.content.Context
import android.provider.MediaStore
import com.rahatshah.mediaplayerdemo.data.model.MediaFile

class MediaRepository(private val context: Context) {

    fun getMedia(): List<MediaFile> {


        val audioFiles = mutableListOf<MediaFile>()

        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.DATA
        )

        context.contentResolver.query(uri, projection, null, null, null)?.use { cursor ->

            val labelColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)

            while (cursor.moveToNext()) {
                val label = cursor.getString(labelColumn)
                val data = cursor.getString(dataColumn)

                audioFiles.add(MediaFile(label = label, data = data))
            }
        }

        return audioFiles
    }
}