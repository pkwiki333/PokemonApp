package com.example.androidpokemonapp.viewModelTesten

import com.example.androidpokemonapp.TestDispatcherRule
import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.viewModel.yourTeam.YourPokemonApiState
import com.example.androidpokemonapp.viewModel.yourTeam.YourTeamViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class YourTeamViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()
    private lateinit var viewModel: YourTeamViewModel
    private lateinit var fakeRepository: FakeApiPokemonRepository

    @Before
    fun setup() {
        fakeRepository = FakeApiPokemonRepository()
        viewModel = YourTeamViewModel(fakeRepository)
    }

        @Test
        fun yourTeamViewModel_initialState_isLoading() = runTest {
            val initialState = viewModel.uiYourpokemonApiState.value
            assertTrue(initialState is YourPokemonApiState.Loading)
        }

        @Test
        fun yourTeamViewModel_fetchYourPokemon_emitsSuccessState() = runTest {
            val expectedPokemonList = FakeApiDataSource.getFakePokmeonListYourTeam()
            fakeRepository.dbPokemonListFlow.tryEmit(expectedPokemonList)

            viewModel.fetchYourPokemon()

            val emittedState = viewModel.uiYourpokemonApiState.first()

            assertTrue(emittedState is YourPokemonApiState.Success)
            assertEquals(expectedPokemonList.asDomainObject(), (emittedState as YourPokemonApiState.Success).pokemonDbList)
        }
    @Test
    fun yourTeamViewModel_retrievesRandomPokemon_successState() = runTest {
        viewModel.fetchYourPokemon()
        val state = viewModel.uiYourpokemonApiState.value

        if (state is YourPokemonApiState.Success) {
            Assert.assertNotNull(state.pokemonDbList)
        }
    }
    }
