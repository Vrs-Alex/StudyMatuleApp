package vrsalex.matule.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import vrsalex.matule.app.App
import javax.inject.Inject
import javax.inject.Singleton
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "storage")

@Singleton
class DataStoreManager @Inject constructor(
    @param:ApplicationContext private val context: Context
) {

    fun getAccessToken(): Flow<String?> =
        context.dataStore.data.map { preferences -> preferences[JWT_ACCESS_TOKEN_KEY] }

    suspend fun saveAccessToken(token: String) =
        context.dataStore.edit { preferences -> preferences[JWT_ACCESS_TOKEN_KEY] = token }

    fun getRefreshToken(): Flow<String?> =
        context.dataStore.data.map { preferences -> preferences[JWT_REFRESH_TOKEN_KEY] }

    suspend fun saveRefreshToken(token: String) =
        context.dataStore.edit { preferences -> preferences[JWT_REFRESH_TOKEN_KEY] = token }


    suspend fun clearTokens() {
        context.dataStore.edit { preferences ->
            preferences.remove(JWT_ACCESS_TOKEN_KEY)
            preferences.remove(JWT_REFRESH_TOKEN_KEY)
        }
    }

    suspend fun savePinCode(pinCode: String) =
        context.dataStore.edit { preferences -> preferences[PIN_CODE_KEY] = pinCode }

    fun getPinCode(): Flow<String?> =
        context.dataStore.data.map { preferences -> preferences[PIN_CODE_KEY] }

    suspend fun saveShowNotification(showNotification: Boolean) =
        context.dataStore.edit { preferences -> preferences[SHOW_NOTIFICATION_KEY] = showNotification }

    fun getShowNotification(): Flow<Boolean?> =
        context.dataStore.data.map { preferences -> preferences[SHOW_NOTIFICATION_KEY] }


    suspend fun saveUserName(userName: String) =
        context.dataStore.edit { preferences -> preferences[USER_NAME_KEY] = userName }

    fun getUserName(): Flow<String?> =
        context.dataStore.data.map { preferences -> preferences[USER_NAME_KEY] }


    suspend fun saveUserPhone(userPhone: String) =
        context.dataStore.edit { preferences -> preferences[USER_PHONE_KEY] = userPhone }

    fun getUserPhone(): Flow<String?> =
        context.dataStore.data.map { preferences -> preferences[USER_PHONE_KEY] }


    suspend fun clearAll() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }


    private companion object {
        val JWT_ACCESS_TOKEN_KEY = stringPreferencesKey("jwt_access_token")
        val JWT_REFRESH_TOKEN_KEY = stringPreferencesKey("jwt_refresh_token")
        val PIN_CODE_KEY = stringPreferencesKey("pin_code")
        val SHOW_NOTIFICATION_KEY = booleanPreferencesKey("show_notification")
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val USER_PHONE_KEY = stringPreferencesKey("user_phone")
    }
}