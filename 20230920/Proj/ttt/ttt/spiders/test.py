import scrapy
from ..items import TestItem



class TestSpider(scrapy.Spider):
    name = "test"
    allowed_domains = ["www.runoob.com"]
    start_urls = ["http://vip.stock.finance.sina.com.cn/corp/view/vRPD_NewStockIssue.php"]


    def parse(self, response):

        data = response.xpath('//*[@id="NewStockTable"]')
        # df = pd.DataFrame(columns=['id','price'])


        count =0;
        cells = data.xpath('tr') #each row
        ItemS =[]
        for cel in cells:
            Item = TestItem()
            # count+=1
            Item['id'] = cel.xpath('./td[1]/div/text()').extract()
            Item['price'] = cel.xpath('./td[8]/div/text()').extract()
            yield Item
            # print(Item['id'],Item['price'])
        next = response.xpath('//*[@id="con02-0"]/table[2]/tr[1]/td/a[text()="下一页"]/@href').extract()[0]
        new_url =  "http://vip.stock.finance.sina.com.cn"+next
        yield scrapy.Request(url=new_url,callback=self.parse,dont_filter=True)
        # Next_url =response.urljoin()
    # def





# //*[@id="con02-0"]/table[2]/tbody/tr[1]/td/a[1]
