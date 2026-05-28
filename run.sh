javac -cp "lanterna-3.1.1.jar" -d . *.java
if [ $? -eq 0 ]; then
    echo "Compilação bem-sucedida! Iniciando..."
    java -cp "lanterna-3.1.1.jar:." com.googlecode.lanterna.vim.Main
else
    echo "Erro na compilação."
fi
