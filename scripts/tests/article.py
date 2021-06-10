import requests
import unittest

host = 'http://localhost:9999'

class TestArticleApi(unittest.TestCase):
    def test_create_article(self):
        """测试创建文章"""

        api = host + "/articles?userId=1998"
        r = requests.post(api, json= { "title": "HW" })
        self.assertEqual(r.status_code, 200)
        print(r.text)

    def test_get_article(self):
        """测试获取文章"""
        r = requests.get('https://bing.com')

        self.assertEqual(r.status_code, 200)

if __name__ == '__main__':
    unittest.main()
