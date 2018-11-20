using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace Exercise
{
    class Program
    {
        static void Main(string[] args)
        {
            var collections = new Dictionary<string, HashSet<string>>();

            var input = Console.ReadLine();

            while (input != "exit")
            {
                var split = input.Split(new[] {'.', '(', ')'}, StringSplitOptions.RemoveEmptyEntries);
                var n = 0;

                if (split.Length > 1)
                {
                    var collection = split[0];

                    for (int i = 1; i < split.Length; i++)
                    {
                        var method = split[i];

                        if (!collections.ContainsKey(collection))
                        {
                            collections[collection] = new HashSet<string>();
                        }
                        collections[collection].Add(method);
                    }
                }else if (int.TryParse(split[0], out n))
                {
                    var intParseCollection = collections
                        .OrderByDescending(x => x.Value.Count)
                        .ThenBy(x => x.Value)
                        .Take(1)
                        .ToDictionary(x => x.Key, x => x.Value);

                    foreach (var entry in intParseCollection)
                    {
                        foreach (
                            var source in entry.Value.Where(x => x.Length > n).OrderBy(x => x.Length).Take(n).ToList())
                        {
                            Console.WriteLine($"* {source}");
                        }
                    }
                }
                else
                {
                    var callectionName = split[0];

                    var collectionFromCollectionName =
                        collections.Where(x => x.Key == callectionName)
                        .ToDictionary(x => x.Key, x => x.Value);
                    foreach (var entry in collectionFromCollectionName)
                    {
                        foreach (var innerEntry in entry.Value.OrderByDescending(x => x.Length).ThenByDescending(x => x.Distinct().Count()).ToArray())
                        {
                            Console.WriteLine($"* {innerEntry}");
                        }
                    }
                    
                }
                input = Console.ReadLine();
            }
        }
    }
}
