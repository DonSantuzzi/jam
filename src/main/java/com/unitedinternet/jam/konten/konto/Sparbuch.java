package com.unitedinternet.jam.konten.konto;

import com.unitedinternet.jam.konten.konto.exception.KontoNichtGedecktException;

public class Sparbuch extends Konto implements Zahlungsverkehrsfaehig {

	private Zinssatz habenZinssatz;

	public Sparbuch(Zinssatz habenZinssatz, String kontonummer) {
		super(kontonummer);
		this.habenZinssatz = habenZinssatz;
	}
	
	@Override
	public float getSaldo() {
		return saldo;
	}

	@Override
	public void einzahlen(float betrag) {
		saldo += betrag;
	}

    @Override
    public boolean istBetragGedeckt(float betrag) {
        return betrag <= saldo;
    }

    @Override
	public void auszahlen(float betrag) throws KontoNichtGedecktException {
		if (saldo >= betrag) {
			saldo -= betrag;
		} else {
			throw new KontoNichtGedecktException(new IllegalArgumentException("bla"), saldo);
		}
	}
	
	public void macheJahresAbschluss() {
		saldo += saldo / 100 * habenZinssatz.gibWert();
	}

	@Override
	public void bucheTransferGebuehren() {
		throw new UnsupportedOperationException("Gebührenabzug nicht erlaubt!");
	}
}
