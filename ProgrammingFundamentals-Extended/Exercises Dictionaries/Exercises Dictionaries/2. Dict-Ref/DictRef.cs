using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.Dict_Ref
{
    class DictRef
    {
        static void Main(string[] args)
        {
            var nameValues = new Dictionary<string , int>();
            var key = "";
            var keySecond = "";
            var value = 0;
            var command = Console.ReadLine();

            while (command != "end")
            {
                for (int i = 0; i < command.Length; i++)
                {
                    string[] split = command.Split(' ');
                    var isParseValue = Int32.TryParse(split[2], out value);
                    

                    if (isParseValue)
                    {
                        key = split[0];
                        value = int.Parse(split[2]);
                        if (!nameValues.ContainsKey(key))
                        {
                            nameValues.Add(key, value);
                        }
                        else
                        {
                            nameValues[key] = value;
                        }
                    }
                    else
                    {
                        key = split[0];
                        keySecond = split[2];
                        if (nameValues.ContainsKey(keySecond))
                        {
                            nameValues[key] = nameValues[keySecond];
                        }
                        
                    }
                }
                

                command = Console.ReadLine();
            }

            foreach (var name in nameValues)
            {
                var nameKey = name.Key;
                var nameValue = name.Value;

                Console.WriteLine($"{nameKey} === {nameValue}");
            }
        }
    }
}
