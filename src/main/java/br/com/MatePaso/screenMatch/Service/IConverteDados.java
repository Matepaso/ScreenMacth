package br.com.MatePaso.screenMatch.Service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
