package com.tatar.expensify.ui.expense.add

import androidx.lifecycle.ViewModel
import com.tatar.expensify.repository.FakeRepository
import timber.log.Timber

class AddExpeseViewModel(private val fakeRepository: FakeRepository) : ViewModel() {

    fun fakeRepoCall() {
        Timber.d("fake call in AddExpeseViewModel")
        fakeRepository.fakeFunction()
    }
}