package com.github.aakira.featuretwo.di

import android.content.Context
import android.content.SharedPreferences
import com.github.aakira.daggerinstantapps.App
import com.github.aakira.daggerinstantapps.data.repository.GithubRepository
import com.github.aakira.daggerinstantapps.di.PerUiScope
import com.github.aakira.daggerinstantapps.ui.DispatcherProvider
import com.github.aakira.featuretwo.ui.issue.IssueListActivity
import com.github.aakira.featuretwo.ui.issue.di.IssueModule
import com.github.aakira.featuretwo.ui.pullrequest.PullRequestListActivity
import com.github.aakira.featuretwo.ui.pullrequest.di.PullRequestModule
import com.github.aakira.featuretwo.ui.pullrequest.flux.PullRequestAction
import com.github.aakira.featuretwo.ui.pullrequest.flux.PullRequestDispatcher
import com.github.aakira.featuretwo.ui.pullrequest.flux.PullRequestStore
import com.github.aakira.featuretwo.ui.repolist.MyFragment
import com.github.aakira.featuretwo.ui.repolist.RepositoryListActivity
import com.github.aakira.featuretwo.ui.repolist.di.RepoListModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class FeatureTwoUiBuilder {

    @PerUiScope
    @ContributesAndroidInjector(modules = [IssueModule::class])
    internal abstract fun bindIssueListActivity(): IssueListActivity

    @PerUiScope
    @ContributesAndroidInjector(modules = [PullRequestModule::class])
    internal abstract fun bindPullRequestListActivity(): PullRequestListActivity

    @PerUiScope
    @ContributesAndroidInjector
//    @ContributesAndroidInjector(modules = [MyFragmentModule::class])
    internal abstract fun bindMyFragment(): MyFragment

    @PerUiScope
    @ContributesAndroidInjector(modules = [RepoListModule::class])
    internal abstract fun bindRepositoryListActivity(): RepositoryListActivity
}

//@Module
//class MyFragmentModule {
//
//    @PerUiScope
//    @Provides
//    fun provideMyFragmentSharedPreferences(preferences: SharedPreferences) = preferences
//
//}