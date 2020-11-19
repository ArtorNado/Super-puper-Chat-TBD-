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
        return Observable.create<Boolean> { observer ->

            db.profileDao().createUserData(
                ProfileEntity(
                    id = 0,
                    name = "Vadem",
                    age = 20,
                    email = "qewrt@mail.ru",
                    about = "Hi, my name is Vadem",
                    status = "Hi, my name is Vadem",
                    imageUrl = ""
                )
            ).subscribe (
                { observer.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.profileDao().createUserData(
                    ProfileEntity(
                        id = 1,
                        name = "Ortem",
                        age = 20,
                        email = "qreqwe@mail.ru",
                        about = "Hi, my name is Ortem",
                        status = "Hi, my name is Ortem",
                        imageUrl = ""
                    )
            ).subscribe (
                { observer.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.profileDao().createUserData(
                    ProfileEntity(
                        id = 2,
                        name = "Seriga",
                        age = 20,
                        email = "qreqwe123@mail.ru",
                        about = "Hi, my name is Seriga",
                        status = "Hi, my name is Seriga",
                        imageUrl = ""
                    )
            ).subscribe (
                { observer.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.profileDao().createUserData(
                    ProfileEntity(
                        id = 3,
                        name = "Dina",
                        age = 20,
                        email = "qreqwe123@mail.ru",
                        about = "Hi, my name is Dina",
                        status = "Hi, my name is Dina",
                        imageUrl = ""
                    )
            ).subscribe (
                { observer.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.profileDao().createUserData(
                    ProfileEntity(
                        id = 4,
                        name = "Nastia",
                        age = 20,
                        email = "qreqwe123@mail.ru",
                        about = "Hi, my name is Nastia",
                        status = "Hi, my name is Nastia",
                        imageUrl = ""
                    )
            ).subscribe (
                { observer.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.profileDao().createUserData(
                    ProfileEntity(
                        id = 5,
                        name = "Emil",
                        age = 20,
                        email = "qreqwe123@mail.ru",
                        about = "Hi, my name is Emil",
                        status = "Hi, my name is Emil",
                        imageUrl = ""
                    )
            ).subscribe (
                { observer.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.dialogDao().createDialog(
                DialogEntity(
                    id = 1,
                    senderId = 1,
                    senderName = "Ortem",
                    imageUrl = "",
                    messages = listOf(
                        Message(
                            userId = 1,
                            messageStatus = 0,
                            message = "Hi, my name Ortem",
                            date = Date()
                        ))
                )
            ).subscribe (
                { observer.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )

            db.dialogDao().createDialog(
                DialogEntity(
                    id = 0,
                    senderId = 2,
                    senderName = "Seriga",
                    imageUrl = "",
                    messages = listOf(
                        Message(
                            userId = 2,
                            messageStatus = 0,
                            message = "Hi, my name Seriga",
                            date = Date()
                        ))
                )
            ).subscribe (
                { observer.onNext(true) },
                { Log.e(this.javaClass.name, it.message.toString()) }
            )
        }
    }
}
