using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3.Forum_Topics
{
    class Program
    {
        static void Main(string[] args)
        {
            var forumTopics = new Dictionary<string, HashSet<string>>();

            var input = Console.ReadLine();

            while (input != "filter")
            {
                string[] split = input.Split(new[] { ' ', '-', '>', ',' }, StringSplitOptions.RemoveEmptyEntries);
                var key = split[0];
                var value = "";

                for (int i = 1; i < split.Length; i++)
                {
                    value = split[i];

                    if (!forumTopics.ContainsKey(key))
                    {
                        forumTopics[key] = new HashSet<string>();
                    }
                    forumTopics[key].Add("#" + value);
                }

                input = Console.ReadLine();
            }

            var filterInput = Console.ReadLine();

            foreach (var nickname in forumTopics.Keys)
            {
                var splitFilterInput = filterInput.Split(new[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries);
                bool isFilterTag = true;
                for (int i = 0; i < splitFilterInput.Length; i++)
                {
                    var filterTag = "#" + splitFilterInput[i];

                    if (!forumTopics[nickname].Contains(filterTag))
                    {
                        isFilterTag = false;
                        break;
                    }
                }

                
                if (isFilterTag)
                {
                    Console.WriteLine("{0} | {1}",nickname, string.Join(", ", forumTopics[nickname]));
                }
            }
        }
    }
}
