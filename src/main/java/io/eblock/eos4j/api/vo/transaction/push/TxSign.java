package io.eblock.eos4j.api.vo.transaction.push;

import io.eblock.eos4j.api.vo.BaseVo;


/**
 * @author mc_q776355102
 * 
 * since：2018年10月11日 下午2:27:52
 */
public class TxSign extends BaseVo {

	public TxSign() {

	}

	public TxSign(String chain_id, Tx transaction) {
		this.chain_id = chain_id;
		this.transaction = transaction;
	}

	private String chain_id;

	private Tx transaction;

	public String getChain_id() {
		return chain_id;
	}

	public void setChain_id(String chain_id) {
		this.chain_id = chain_id;
	}

	public Tx getTransaction() {
		return transaction;
	}

	public void setTransaction(Tx transaction) {
		this.transaction = transaction;
	}

}
