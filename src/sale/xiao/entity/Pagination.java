package sale.xiao.entity;

import java.util.List;

public class Pagination<T> {
    // 分页数据
    private List<T> records;

    // 总的记录数
    private int     totalRecord;

    // 当前页面，表示第几页
    private int     pageNo     = 1;

    // 每页显示的条数
    private int     pageSize;

    // 总页数
    private int     totalPage;

    // 开始索引
    private int     startIndex;

    // 结束索引
    private int     endIndex;

    // 显示索引数目
    private int     indexCount = 11;



    /**
     * 
     * @param records
     * @param totalRecord
     * @param pageNo
     * @param pageSize
     */
    public Pagination(List<T> records, int totalRecord, int pageNo, int pageSize) {
        this.records = records;
        this.totalRecord = totalRecord;
        this.pageNo = pageNo;
        this.pageSize = pageSize;

        // 计算一共多少页
        this.totalPage = this.totalRecord / this.pageSize;
        this.totalPage = (this.totalRecord % this.pageSize == 0) ? this.totalPage : this.totalPage + 1;

        // 页面div显示从好多开始展示
        this.startIndex = this.indexCount - 5;

        // this.indexCount 显示页码个数
        this.startIndex = pageNo - (this.indexCount % 2 == 0 ? (this.startIndex - 1) : this.startIndex);

        this.endIndex = this.pageNo + this.indexCount - 5;
        if (this.startIndex < 1) {
            this.startIndex = 1;
            if (this.totalPage >= this.indexCount) {
                this.endIndex = this.indexCount;
            } else {
                this.endIndex = totalPage;
            }
        }

        if (this.endIndex > this.totalPage) {
            this.endIndex = this.totalPage;
            if (this.endIndex > this.indexCount) {
                this.startIndex = this.endIndex - this.indexCount + 1;
            } else {
                this.startIndex = 1;
            }
        }
    }



    public List<T> getRecords() {
        return records;
    }



    public int getPageNo() {
        return pageNo;
    }



    public int getTotalPage() {
        return totalPage;
    }



    // 开始索引
    public int getStartIndex() {
        return startIndex;
    }



    public int getEndIndex() {
        return this.endIndex;
    }



    public int getIndexCount() {
        return this.indexCount;
    }



    public void setIndexCount(int indexCount) {
        this.indexCount = indexCount;
    }



    public int getTotalRecord() {
        return totalRecord;
    }
}
