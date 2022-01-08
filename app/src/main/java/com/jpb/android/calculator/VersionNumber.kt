// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package com.jpb.android.calculator

import com.jpb.android.calculator.VersionNumber
import android.os.Build
import com.jpb.android.calculator.VersionNumberGetter
import com.jpb.android.calculator.R
import java.lang.NumberFormatException
import java.util.*

/**
 * Utility for dealing with Chrome version numbers.
 */
class VersionNumber {
    private val mVersion = intArrayOf(0, 0, 0, 0)
    override fun toString(): String {
        return String.format(
            Locale.US, "%d.%d.%d.%d", mVersion[0], mVersion[1], mVersion[2],
            mVersion[3]
        )
    }

    /**
     * @return whether this VersionNumber is smaller than the given one, going from left to right.
     */
    fun isSmallerThan(version: VersionNumber): Boolean {
        for (i in 0..3) {
            if (mVersion[i] < version.mVersion[i]) {
                return true
            } else if (mVersion[i] > version.mVersion[i]) {
                return false
            }
        }
        return false
    }

    companion object {
        /**
         * Parses out the version numbers from a given version string.
         * @param str a version number of the format a.b.c.d, where each is an integer.
         * @return A VersionNumber containing the version info, or null if it couldn't be parsed.
         */
        fun fromString(str: String?): VersionNumber? {
            if (str == null) {
                return null
            }

            // Parse out the version numbers.
            val pieces = str.split("\\.").toTypedArray()
            if (pieces.size != 4) {
                return null
            }
            val version = VersionNumber()
            try {
                for (i in 0..3) {
                    version.mVersion[i] = pieces[i].toInt()
                }
            } catch (e: NumberFormatException) {
                return null
            }
            return version
        }
    }
}