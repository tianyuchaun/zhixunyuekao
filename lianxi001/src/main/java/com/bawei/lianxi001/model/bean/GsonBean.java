package com.bawei.lianxi001.model.bean;

import java.util.List;

public class GsonBean {

    /**
     * result : [{"commodityId":135,"commodityName":"青春时尚 潮流男鞋 韩版舒适简约百搭板鞋男士休闲鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/1/1.jpg","price":149,"saleNum":26},{"commodityId":146,"commodityName":"时尚潮流 男鞋 套脚休闲板鞋帆布鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/5/1.jpg","price":129,"saleNum":0},{"commodityId":140,"commodityName":"小白鞋男时尚新款运动休闲男鞋韩版潮流厚底原宿风板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/6/1.jpg","price":398,"saleNum":0},{"commodityId":137,"commodityName":"唐狮冬季男士冬休闲鞋高帮男鞋男士板鞋休闲男鞋子高帮男鞋百搭休闲板鞋男","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/3/1.jpg","price":79,"saleNum":3},{"commodityId":145,"commodityName":"如熙新款男鞋韩版学生时尚百搭潮流低帮男帆布鞋简约英伦风舒适男板鞋轻便耐磨系带潮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nfbx/4/1.jpg","price":119,"saleNum":3},{"commodityId":139,"commodityName":"秋季男鞋简约百搭男小白鞋韩版潮流男板鞋跑步鞋子ins超火的运动鞋学生时尚嘻哈潮鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/5/1.jpg","price":109,"saleNum":0},{"commodityId":136,"commodityName":"板鞋休闲鞋男男士休闲运动鞋男士鞋子休闲皮鞋男士休闲鞋男鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/2/1.jpg","price":99,"saleNum":0},{"commodityId":141,"commodityName":"AUXTUN港仔原宿男鞋秋季鞋子男潮鞋百搭韩版潮流男士休闲鞋板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/7/1.jpg","price":99,"saleNum":0},{"commodityId":138,"commodityName":"秋男鞋时尚男士休闲鞋系带防磨脚男士皮鞋潮流休闲板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/nbx/4/1.jpg","price":449,"saleNum":0},{"commodityId":18,"commodityName":"白色经典 秋季新款简约百搭轻便休闲女鞋板鞋小白鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/1/1.jpg","price":79,"saleNum":3},{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88,"saleNum":12},{"commodityId":22,"commodityName":"冬季保暖加绒女士棉鞋 韩版拼色低帮板鞋学生休闲鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/5/1.jpg","price":119,"saleNum":0},{"commodityId":37,"commodityName":"轻便舒适 女鞋 简约百搭一脚蹬套脚女款板鞋休闲帆布鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/fbx/6/1.jpg","price":99,"saleNum":0},{"commodityId":24,"commodityName":"百搭小白鞋 女款 时尚舒适板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/7/1.jpg","price":149,"saleNum":0},{"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/2/1.jpg","price":78,"saleNum":27},{"commodityId":35,"commodityName":"唐狮女款小白鞋百搭秋季新款女鞋女款板鞋休闲鞋子帆布鞋女","masterPic":"http://172.17.8.100/images/small/commodity/nx/fbx/4/1.jpg","price":78,"saleNum":0},{"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","masterPic":"http://172.17.8.100/images/small/commodity/nx/bx/6/1.jpg","price":139,"saleNum":54}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 135
         * commodityName : 青春时尚 潮流男鞋 韩版舒适简约百搭板鞋男士休闲鞋
         * masterPic : http://172.17.8.100/images/small/commodity/nx/nbx/1/1.jpg
         * price : 149
         * saleNum : 26
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
