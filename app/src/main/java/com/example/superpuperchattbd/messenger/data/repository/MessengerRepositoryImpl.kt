package com.example.superpuperchattbd.messenger.data.repository

import android.util.Log
import androidx.paging.DataSource
import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.common_messenger.Message
import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.core_db.model.DialogEntity
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import com.example.superpuperchattbd.messenger.data.interfaces.MessengerRepository
import com.example.superpuperchattbd.messenger.data.mappers.mapDialogEntityToLocal
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class MessengerRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : MessengerRepository {

    override fun getData(): DataSource.Factory<Int, Dialog> {
        return db.dialogDao().getDialogs()
            .map { mapDialogEntityToLocal(it) }
    }

    override fun createModels(): Observable<Boolean> {
        return Observable.create<Boolean> {
            db.profileDao().saveUserData(
                ProfileEntity(
                    id = 0,
                    name = "Vadim",
                    age = 20,
                    email = "qewrt@mail.ru",
                    about = "Hi, my name is vadim",
                    status = "Hi, my name is vadim",
                    imageUrl = ""
                )
            ).subscribe (
                { it.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.profileDao().saveUserData(
                    ProfileEntity(
                        id = 1,
                        name = "Artem",
                        age = 20,
                        email = "qreqwe@mail.ru",
                        about = "Hi, my name is artem",
                        status = "Hi, my name is artem",
                        imageUrl = ""
                    )
            ).subscribe (
                { it.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.profileDao().saveUserData(
                    ProfileEntity(
                        id = 2,
                        name = "Seriga",
                        age = 20,
                        email = "qreqwe123@mail.ru",
                        about = "Hi, my name is seriga",
                        status = "Hi, my name is seriga",
                        imageUrl = ""
                    )
            ).subscribe (
                { it.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.dialogDao().setDialog(
                DialogEntity(
                    id = 1,
                    senderId = 1,
                    imageUrl = "",
                    messages = listOf(
                        Message(
                            userId = 1,
                            messageStatus = 0,
                            message = "Hi, my name vadim",
                            date = Date()
                        ))
                )
            ).subscribe (
                { it.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.dialogDao().setDialog(
                DialogEntity(
                    id = 0,
                    senderId = 2,
                    imageUrl = "",
                    messages = listOf(
                        Message(
                            userId = 2,
                            messageStatus = 0,
                            message = "Hi, my name artem",
                            date = Date()
                        ))
                )
            ).subscribe (
                { it.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )
        }
    }
}
