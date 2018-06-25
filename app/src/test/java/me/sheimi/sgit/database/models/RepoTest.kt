package me.sheimi.sgit.database.models

import org.junit.Assert.assertEquals
import org.junit.Test

class RepoTest {

    @Test
    fun testGetCurrentDisplayName() {
        assertEquals("", "remotes/foo", Repo.getCommitDisplayName("refs/remotes/foo"))
        assertEquals("", "remotes/foo/bar", Repo.getCommitDisplayName("refs/remotes/foo/bar"))
        assertEquals("", "foo", Repo.getCommitDisplayName("refs/heads/foo"))
        assertEquals("", "foo/bar", Repo.getCommitDisplayName("refs/heads/foo/bar"))
        assertEquals("", "foo/bar", Repo.getCommitDisplayName("refs/tags/foo/bar"))
        assertEquals("", "foo/bar", Repo.getCommitDisplayName("refs/tags/foo/bar"))
        assertEquals("", "refs/blah/foo/bar", Repo.getCommitDisplayName("refs/blah/foo/bar"))

        assertEquals("incomlete ref name must return itself string, not cause exception", "re", Repo.getCommitDisplayName("re"))
    }

    @Test
    fun testgetCommitType() {
        assertEquals("should be type head", Repo.COMMIT_TYPE_HEAD.toLong(), Repo.getCommitType("refs/heads/foo").toLong())
        assertEquals("should be type head", Repo.COMMIT_TYPE_HEAD.toLong(), Repo.getCommitType("refs/heads/foo/bar").toLong())
        assertEquals("should be type remote", Repo.COMMIT_TYPE_REMOTE.toLong(), Repo.getCommitType("refs/remotes/foo").toLong())
        assertEquals("should be type remote", Repo.COMMIT_TYPE_REMOTE.toLong(), Repo.getCommitType("refs/remotes/foo/bar").toLong())
        assertEquals("should be type remote", Repo.COMMIT_TYPE_TAG.toLong(), Repo.getCommitType("refs/tags/foo/bar").toLong())
        assertEquals("should be type remote", Repo.COMMIT_TYPE_TAG.toLong(), Repo.getCommitType("refs/tags/foo/bar").toLong())
        assertEquals("should be type remote", Repo.COMMIT_TYPE_UNKNOWN.toLong(), Repo.getCommitType("refs/blah/foo/bar").toLong())
    }
}
