using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4.Social_Media_Posts
{
    class Program
    {
        static void Main(string[] args)
        {
            var socialMedia = new Dictionary<string, Dictionary<string, List<string>>>();

            var input = Console.ReadLine();

            while (input != "drop the media")
            {
                string[] split = input.Split(' ');
                var command = split[0];
                var postName = split[1];

                if (!socialMedia.ContainsKey(postName))
                {
                    socialMedia[postName] = new Dictionary<string, List<string>>();
                }

                switch (command)
                {
                    case "like":

                        if (!socialMedia[postName].ContainsKey(command))
                        {
                            socialMedia[postName]["Likes"] = new List<string>();
                        }
                        socialMedia[postName]["Likes"].Add(command);
                        break;

                    case "dislike":

                        if (!socialMedia[postName].ContainsKey(command))
                        {
                            socialMedia[postName]["Dislikes"] = new List<string>();
                        }
                        socialMedia[postName]["Dislikes"].Add(command);
                        break;

                    case "comment":

                        var commentator = split[2];
                        int length = command.Length + postName.Length + commentator.Length + 3;
                        var comment = input.Substring(length);

                        socialMedia[postName][commentator] = new List<string>();
                        socialMedia[postName][commentator].Add(comment);
                        break;
                        
                }

                input = Console.ReadLine();
            }

            foreach (var post in socialMedia.Keys)
            {
                var likes = 0;
                var dislikes = 0;
                 

                foreach (var item in socialMedia[post].Keys)
                {
                    if (item == "Likes")
                    {
                        likes++;
                    }
                    else if (item == "Dislikes")
                    {
                        dislikes++;
                    }
                    
                   
                }

                Console.WriteLine($"Post: {post} | Likes: {likes} | Dislikes {dislikes}");
                Console.WriteLine("Comments:");

                bool isNotComment = true;

                foreach (var comment in socialMedia[post].Keys)
                {
                    if (!(comment == "like" && comment == "dislike"))
                    {
                        Console.WriteLine($"*  {socialMedia[post]}: {comment}");
                        isNotComment = false;
                    }
                }

                if (isNotComment)
                {
                    Console.WriteLine("None");
                }
            }
        }
    }
}
