package com.iherrera.kotlinmvp

import com.iherrera.kotlinmvp.login.LoginActivityMVP
import com.iherrera.kotlinmvp.login.model.User
import com.iherrera.kotlinmvp.login.presenter.LoginActivityPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*


/**
 * Unit Test de LoginActivityPresenter
 */
class PresenterUnitTest {

    private lateinit var presenter: LoginActivityPresenter
    private lateinit var user: User

    // Variables simuladas
    private lateinit var mockedModel: LoginActivityMVP.Model
    private lateinit var mockedView: LoginActivityMVP.View

    // Se encarga de limpiar sus valores antes de ejecutar cada una de las pruebas
    @Before
    fun initialization() {
        mockedModel = mock(LoginActivityMVP.Model::class.java)
        mockedView = mock(LoginActivityMVP.View::class.java)
        user = User("Antonio", "Banderas")

        // Implementacion concreta
        presenter = LoginActivityPresenter(mockedModel)
        presenter.setView(mockedView)
    }

    @Test
    fun noExistInteractionWithView() {
        presenter.getCurrentUser()
        // Flujo de usuario no inicializado
        verify(mockedView, times(1)).showUserNotAvailable()
    }

    @Test
    fun loadUserFromTheRepoWhenValidUserIsPresenter() {
        // Simular metodos de la interfaz de Modelo
        `when`(mockedModel.getUser()).thenReturn(user)
        presenter.getCurrentUser()

        // Comprobamos la interactuacion con el modelo de datos
        verify(mockedModel, times(1)).getUser()

        // Comprobamos la interactuacion con la vista
        verify(mockedView, times(1)).setFirstName("Antonio")
        verify(mockedView, times(1)).setLastName("Banderas")
        verify(mockedView, never()).showUserNotAvailable()
    }

    @Test
    fun showErrorMessageWhenUserIsNull() {
        `when`(mockedModel.getUser()).thenReturn(null)
        presenter.getCurrentUser()

        // Comprobamos la interactuacion con el modelo de datos
        verify(mockedModel, times(1)).getUser()

        // Comprobamos la interactuacion con la vista
        verify(mockedView, never()).setFirstName("Antonio")
        verify(mockedView, never()).setLastName("Banderas")
        verify(mockedView, times(1)).showUserNotAvailable()
    }

    @Test
    fun createErrorMessageIfAnyFieldIsEmpty() {
        // Primer prueba
        `when`(mockedView.getFirstName()).thenReturn("")
        presenter.loginButtonClicked()
        verify(mockedView, times(1)).getFirstName()
        verify(mockedView, never()).getLastName()
        verify(mockedView, times(1)).showInputError()

        // Segunda Prueba
        `when`(mockedView.getFirstName()).thenReturn("Antonio")
        `when`(mockedView.getLastName()).thenReturn("")
        presenter.loginButtonClicked()
        verify(mockedView, times(2)).getFirstName()
        verify(mockedView, times(1)).getLastName()
        verify(mockedView, times(2)).showInputError()
    }

    @Test
    fun saveValidUser() {
        `when`(mockedView.getFirstName()).thenReturn("Antonio")
        `when`(mockedView.getLastName()).thenReturn("Banderas")
        presenter.loginButtonClicked()
        verify(mockedView, times(2)).getFirstName()
        verify(mockedView, times(2)).getLastName()

        // Comprobamos la interactuacion con el modelo de datos
        verify(mockedModel, times(1)).createUser("Antonio", "Banderas")
        // Comprobamos la interactuacion con la Vista
        verify(mockedView, times(1)).showUserSaved()
    }
}