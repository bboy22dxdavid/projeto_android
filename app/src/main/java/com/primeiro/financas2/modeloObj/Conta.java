package com.primeiro.financas2.modeloObj;
/*
 * @author David nilo
 * on 12/11/2019.
 */
public class Conta {

    private Integer codigo;
    private Integer valor;
    private String  conta;
    private byte    registroAtivo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public byte getRegistroAtivo() {
        return registroAtivo;
    }

    public void setRegistroAtivo(byte registroAtivo) {
        this.registroAtivo = registroAtivo;
    }
}
