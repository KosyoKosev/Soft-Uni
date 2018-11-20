using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3.Mixed_Phones
{
    class MixedPhones
    {
        static void Main(string[] args)
        {
            var pfoneBook = new SortedDictionary<string, long>();
            var key = "";
            long value;
            
            var command = Console.ReadLine();

            while (command != "Over")
            {
                for (int i = 0; i < command.Length; i++)
                {
                    string[] split = command.Split(new char[]{' ',':'},StringSplitOptions.RemoveEmptyEntries);
                    key = split[0];
                    bool keyParseToInt = Int64.TryParse(key,out value);

                    if (keyParseToInt)
                    {
                        key = split[1];
                        value = long.Parse(split[0]);
                    }
                    else
                    {
                        key = split[0];
                        value = long.Parse(split[1]);
                    }

                    pfoneBook.Add(key, value);
                    break;
                }

                command = Console.ReadLine();
            }

            foreach (var name in pfoneBook)
            {
                Console.WriteLine($"{name.Key} -> {name.Value}");
            }
        }
    }
}
