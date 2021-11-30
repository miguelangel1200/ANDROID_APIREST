package com.applikdos.restservicewithkotlin.presenter

import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import com.applikdos.restservicewithkotlin.model.MainInteractor
import com.applikdos.restservicewithkotlin.view.MainActivity
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class MainPresenterImplTest {

    private val view: MainActivity = mock()
    private val mainInteractor: MainInteractor = mock()
    private lateinit var presenter: MainPresenterImpl

    @Before
    fun setUp() {
        presenter = MainPresenterImpl(view, mainInteractor)
    }

    @Test
    fun should_InvokeListUsers_When_PresenterIsCalled() {
        val testObserver: TestObserver<List<UserDataCollectionItem>> = TestObserver()
        mainInteractor.listUsers(testObserver)
        presenter.listUsers()
        verify(mainInteractor, times(1)).listUsers(testObserver)
    }

    @Test
    fun should_ReturnDataCollection_When_IsCorrectResult() {
        val result: List<UserDataCollectionItem> = listOf()
        val testObserver: TestObserver<List<UserDataCollectionItem>> = TestObserver()
        mainInteractor.listUsers(testObserver)
        presenter.listUsers()
        testObserver.assertNoErrors()
        testObserver.onComplete()
        testObserver.onNext(result)
        assertEquals(testObserver.values().get(0), result)

    }

    @Test
    fun should_InvokeShowResultMethod_When_IsResultSuccess() {
        val result: List<UserDataCollectionItem> = listOf()
        val testObserver: TestObserver<List<UserDataCollectionItem>> = TestObserver()
        view.showResult(result)
        presenter.listUsers()
        testObserver.onComplete()
        verify(view, times(1)).showResult(result)
    }

    @Test
    fun should_InvokeErrorResultMethod_When_IsErrorResult() {
        val testObserver: TestObserver<List<UserDataCollectionItem>> = TestObserver()
        view.errorResult(anyString())
        presenter.listUsers()
        testObserver.onError(Throwable())
        verify(view, times(1)).errorResult(anyString())
    }
}