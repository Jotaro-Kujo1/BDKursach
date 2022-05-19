using System;
using System.Collections.Generic;
using System.Text;
using System.Data.OleDb;
using System.Text.Json;
using System.IO;
using System.Text.Encodings.Web;
using DocumentFormat.OpenXml.Spreadsheet;
using Word = Microsoft.Office.Interop.Word;

namespace Utility
{
    


    public class ODBCConnection
    {
        private OleDbConnection _connection;


        public void InitializeConnection()
        {
            const string connectionString = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=LaborExchange.mdb;";
            _connection = new OleDbConnection(connectionString);
        }

        public ODBCConnection()
        {
            InitializeConnection();
        }

        public bool OpenConnection()
        {
            try
            {
                _connection.Open();
                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine("Connection open Error: " + e.Message);
                return false;
            }
        }

        public bool CloseConnection()
        {
            try
            {
                _connection.Close();
                return true;
            }
            catch (Exception e)
            {

                Console.WriteLine("Connection close Error: " + e.Message);
                return false;
            }
        }

        public List<Unemployed> readResultSet()
        {
            var query = "SELECT * FROM unemployed";
            var cmd = new OleDbCommand(query, _connection);
            var result = new List<Unemployed>();

            if (OpenConnection())
            {
                try
                {
                    var reader = cmd.ExecuteReader();
                    while(reader!=null && reader.Read())
                    {
                        result.Add(new Unemployed(Convert.ToInt32(reader["Id"]), Convert.ToString(reader["Фамилия"]), Convert.ToString(reader["Имя"]),
                            Convert.ToString(reader["Отчество"]),
                            Convert.ToInt32(reader["Возраст"]),
                            Convert.ToInt32(reader["Пол"]),
                            Convert.ToInt32(reader["Образование"]),
                            Convert.ToInt32(reader["Опыт"]),
                            Convert.ToString(reader["Контакты"]),
                            Convert.ToInt32(reader["Страна"]),
                            Convert.ToInt32(reader["Предыдущее место работы"]),
                            Convert.ToString(reader["Паспорт"])));
                        
                    }
                    return result;
                }catch (Exception e)
                {
                    return null;
                }
                finally
                {
                    CloseConnection();
                }
            }
            return null;
        }

        public void WriteInfoJson(List<Unemployed> list, string path)
        {
            JsonSerializerOptions options = new JsonSerializerOptions()
            {
                WriteIndented = true
            };

            File.WriteAllText("Data.json", JsonSerializer.Serialize(list,options));
        
            
        }

        /*
        public List<Unemployed> ReadJson(string path)
        {
            try
            {
                return JsonSerializer.Deserialize<List<Unemployed>>(File.ReadAllText(path));
            }
            catch
            {
                return new List<Unemployed>();
            }
        }
        */
        public void WriteWord()
        {
            var wordApp = new Word.Application();
            wordApp.Visible = false;
            var wordDocument = wordApp.Documents.Open(@"c:\\Javist\BDKurs\Util\Utility\Utility\test.docx");
            var range = wordDocument.Content;
            wordDocument.
        }
    }
    

}
