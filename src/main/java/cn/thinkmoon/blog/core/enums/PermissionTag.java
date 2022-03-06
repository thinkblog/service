package cn.thinkmoon.blog.core.enums;

public enum PermissionTag {
    ADMIN("admin");

    String tag;

    PermissionTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "PermissionTag{" +
                "tag='" + tag + '\'' +
                '}';
    }
}
