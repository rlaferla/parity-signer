package io.parity.signer.domain.storage

import io.parity.signer.dependencygraph.ServiceLocator
import io.parity.signer.domain.MainFlowViewModel
import io.parity.signer.domain.navigate
import io.parity.signer.uniffi.Action

fun MainFlowViewModel.signSufficientCrypto(seedName: String, addressKey: String) {
	ServiceLocator.authentication.authenticate(activity) {
		val seedPhrase = getSeed(
			seedName
		)
		if (seedPhrase.isNotBlank()) {
			navigate(
				Action.GO_FORWARD,
				addressKey,
				seedPhrase
			)
		}
	}
}